function greet(name) {
    return function() {
      console.log("Hello " + name);
    }
  }
  
  const greetSuraj = greet("Suraj");
  
  greetSuraj();

// Next program
function outer() {
let a = 10;
let b = 20;

function inner() {
    console.log(a + b);
}

return inner;
}

const fn = outer();
fn();


//next program
for(var i = 1; i <= 3; i++){
    setTimeout(function(){
      console.log(i);
    },1000);
  }
  