/**
 * 
 */

const tl = gsap.timeline({defaults: {ease: 'power1.out'}});
   tl.fromTo('#logo', {opacity: 0}, {opacity:1, duration:1})
  .fromTo('nav', {opacity: 0}, {opacity:1, duration:1},"-=1");  
   tl.fromTo(".stats", {y: -230}, {duration: 1.6, y: -75},"-=1")
  .fromto(".stats" , 0, {  opacity:0.5 , ease:Power1.easeInOut });
