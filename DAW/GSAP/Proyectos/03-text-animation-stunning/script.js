var h1 =document.querySelector("h1");
var h1Text =h1.textContent;

var splitText = h1Text.split("")
var clutter = ""

splitText.forEach(function(elem,ind){
 clutter += `<span class="${ind}">${elem}</span>`
})

h1.innerHTML =clutter;

gsap.from("h1 span",{
    y:100,
    opacity:0,
    duration:1,
    dealy:0.5,
    stagger:0.15

})