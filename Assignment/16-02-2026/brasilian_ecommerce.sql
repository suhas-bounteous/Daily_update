CREATE TABLE olist_customers_dataset (
    customer_id VARCHAR(50) PRIMARY KEY,
    customer_unique_id VARCHAR(50),
    customer_zip_code_prefix INT,
    customer_city VARCHAR(50),
    customer_state CHAR(2)
);

CREATE TABLE olist_orders_dataset (
    order_id VARCHAR(50) PRIMARY KEY,
    customer_id VARCHAR(50),
    order_status VARCHAR(20),
    order_purchase_timestamp TIMESTAMP,
    order_approved_at TIMESTAMP,
    order_delivered_carrier_date TIMESTAMP,
    order_delivered_customer_date TIMESTAMP,
    order_estimated_delivery_date TIMESTAMP
);

CREATE TABLE olist_order_items_dataset (
    order_id VARCHAR(50),
    order_item_id INT,
    product_id VARCHAR(50),
    seller_id VARCHAR(50),
    shipping_limit_date TIMESTAMP,
    price NUMERIC(10,2),
    freight_value NUMERIC(10,2)
);


CREATE TABLE olist_products_dataset (
    product_id VARCHAR(50) PRIMARY KEY,
    product_category_name VARCHAR(100),
    product_name_lenght INT,
    product_description_lenght INT,
    product_photos_qty INT,
    product_weight_g INT,
    product_length_cm INT,
    product_height_cm INT,
    product_width_cm INT
);


--1
WITH monthly_orders AS (
    SELECT
        c.customer_state,
        DATE_TRUNC('month', o.order_purchase_timestamp) AS month,
        COUNT(*) AS total_orders
    FROM olist_orders_dataset o
    JOIN olist_customers_dataset c
        ON o.customer_id = c.customer_id
    WHERE o.order_purchase_timestamp >= '2017-11-01'
      AND o.order_purchase_timestamp < '2018-01-01'
    GROUP BY c.customer_state, month
),
mom_growth AS (
    SELECT
        customer_state,
        SUM(CASE WHEN month = '2017-11-01' THEN total_orders END) AS nov_orders,
        SUM(CASE WHEN month = '2017-12-01' THEN total_orders END) AS dec_orders,
        (SUM(CASE WHEN month = '2017-12-01' THEN total_orders END)
         - SUM(CASE WHEN month = '2017-11-01' THEN total_orders END)) * 1.0
         / SUM(CASE WHEN month = '2017-11-01' THEN total_orders END) AS growth_rate
    FROM monthly_orders
    GROUP BY customer_state
),
high_growth_states AS (
    SELECT customer_state
    FROM mom_growth
    WHERE growth_rate > 0.05
)
SELECT *
FROM (
    SELECT
        c.customer_state,
        p.product_category_name,
        SUM(oi.price) AS total_revenue,
        ROW_NUMBER() OVER (
            PARTITION BY c.customer_state
            ORDER BY SUM(oi.price) DESC
        ) AS rank
    FROM olist_orders_dataset o
    JOIN olist_customers_dataset c
        ON o.customer_id = c.customer_id
    JOIN olist_order_items_dataset oi
        ON o.order_id = oi.order_id
    JOIN olist_products_dataset p
        ON oi.product_id = p.product_id
    WHERE EXTRACT(YEAR FROM o.order_purchase_timestamp) = 2017
      AND c.customer_state IN (SELECT customer_state FROM high_growth_states)
    GROUP BY c.customer_state, p.product_category_name
) ranked
WHERE rank <= 3
ORDER BY customer_state, rank;



--2
WITH customer_segments AS (
    SELECT
        c.customer_unique_id,
        CASE 
            WHEN COUNT(DISTINCT o.order_id) >= 2 THEN 'high_value'
            WHEN COUNT(DISTINCT o.order_id) = 1 AND SUM(oi.price) < 100 THEN 'low_value'
            ELSE 'other'
        END AS customer_type
    FROM olist_customers_dataset c
    JOIN olist_orders_dataset o
        ON c.customer_id = o.customer_id
    JOIN olist_order_items_dataset oi
        ON o.order_id = oi.order_id
    GROUP BY c.customer_unique_id
),
first_orders AS (
    SELECT
        c.customer_unique_id,
        o.order_id,
        ROW_NUMBER() OVER (
            PARTITION BY c.customer_unique_id
            ORDER BY o.order_purchase_timestamp
        ) AS rn
    FROM olist_customers_dataset c
    JOIN olist_orders_dataset o
        ON c.customer_id = o.customer_id
),
first_order_categories AS (
    SELECT
        cs.customer_type,
        p.product_category_name
    FROM first_orders fo
    JOIN customer_segments cs
        ON fo.customer_unique_id = cs.customer_unique_id
    JOIN olist_order_items_dataset oi
        ON fo.order_id = oi.order_id
    JOIN olist_products_dataset p
        ON oi.product_id = p.product_id
    WHERE fo.rn = 1
      AND cs.customer_type IN ('high_value','low_value')
),
ranked_categories AS (
    SELECT
        customer_type,
        product_category_name,
        COUNT(*) AS cnt,
        ROW_NUMBER() OVER (
            PARTITION BY customer_type
            ORDER BY COUNT(*) DESC
        ) AS rank
    FROM first_order_categories
    GROUP BY customer_type, product_category_name
)
SELECT customer_type, product_category_name, cnt
FROM ranked_categories
WHERE rank <= 3
ORDER BY customer_type, rank;



