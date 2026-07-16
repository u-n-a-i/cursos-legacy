var main = document.querySelector("#main");
var cursor = document.querySelector("#cursor");
var image = document.querySelector("#image");

main.addEventListener("mousemove",function(dets){
    // console.log("Event Performed");
    // console.log(dets.x)
    gsap.to(cursor,{
        x:dets.x,
        y:dets.y
    })

})

image.addEventListener("mouseenter",function(){
    cursor.innerHTML = "View More"
    gsap.to(cursor,{
        scale:4
    })
})
image.addEventListener("mouseleave",function(){
    cursor.innerHTML = " "
    gsap.to(cursor,{
        scale:1
    })
})