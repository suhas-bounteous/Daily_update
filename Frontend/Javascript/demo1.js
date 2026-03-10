var num = 5;
var num1 = 8;

function add(a,b){
    return a+b;
}

const sum = add(num, num1);
const sum1 = add(4,4);
console.log("The sum of num and num1 is: " + sum);

const arr = [1,2,3,4,5,6,7,8,9,0];
 
const result = arr.map(num => {
    if (num%2 == 0) {
        return num;
    }
});
 
console.log(result);