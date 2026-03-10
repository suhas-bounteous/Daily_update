function createCounter(){
    let count = 0;

    return {
        increment: function(){
            count++;
            return count;
        },

        decrement: function(){
            count--;
            return count;
        }
    }
}

const counter = createCounter();

function increase() {
    document.getElementById("count").textContent = counter.increment();
}

function decrease() {
    document.getElementById("count").textContent = counter.decrement();
}
