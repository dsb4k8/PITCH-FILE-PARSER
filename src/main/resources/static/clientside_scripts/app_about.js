TweenMax.defaultEase = Linear.easeOut;

new fullpage("#fullpage", {
  //options here
  autoScrolling: true,
  navigation: true,
  afterSlideLoad: function( section, origin, destination, direction){
    console.log('afterSlideLoad ' + destination.index)
},

afterLoad: function(origin, destination, direction){
     console.log('afterLoad ' + destination.index)
  
},
  onLeave: (origin, destination, direction) => {
    const section = destination.item;
    const title = section.querySelector("h1");
    const tl = new TimelineMax({ delay: 0.5 });
    tl.fromTo(title, 0.5, { y: "50", opacity: 0 }, { y: "0", opacity: 1 });

    if (destination.index === 1 ) {
      const docs = document.querySelectorAll(".doc");
      const description = document.querySelector(".description");
      tl.fromTo(docs, 0.7, { x: "100%" }, { x: "-5%" })
        .fromTo(
          description,
          0.5,
          { opacity: 0, y: "50" },
          { y: "0", opacity: 1 }
        )
        .fromTo(docs[0], 0.5, { opacity: 1 }, { opacity: 1 })
        .fromTo(docs[1], 0.5, { opacity: 0 }, { opacity: 1 })
        .fromTo(docs[2], 0.5, { opacity: 0 }, { opacity: 1 })
        .fromTo(docs[3], 0.5, { opacity: 0 }, { opacity: 1 });
        
    }

    if (destination.index === 2 ) {
      const stack = document.querySelectorAll(".stack");
      const description = document.querySelector(".description");
      tl.fromTo(stack, 0.7, { x: "100%" }, { x: "20%" })
        .fromTo(
          description,
          1,
          { opacity: 0, y: "50" },
          { y: "0", opacity: 1 }
        )
        .fromTo(stack[0], 0.5, { opacity: 0 }, { opacity: 1 });
        
    }
  }
});
