/**
 * 
 */
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
$('.big-number').each(function() {
		  var $this = $(this),
		      countTo = $this.attr('data-count');
		  
		  $({ countNum: $this.text()}).animate({
		    countNum: countTo
		  },

		  {

		    duration: 2000,
		    easing:'linear',
		    step: function() {
		      $this.text(Math.floor(this.countNum));
		    },
		    complete: function() {
		      $this.text(numberWithCommas(this.countNum));
		      //alert('finished');
		    }

		  });  
		  
		  

		});
		
		