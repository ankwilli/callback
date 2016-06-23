//      Pop Easy | jQuery Modal Plugin



(function($){

    $.fn.modal= function(options){
       
       /* options = $.extend({
            olay: '.overlay',
            modals: '.modal',
            animationEffect: 'fadeIn',
            animationSpeed: 100,
            moveModalSpeed: 'fast',
            background: '000000',
            opacity: 0.8,
            openOnLoad: true,
            docClose: true,
            closeByEscape: true,
            moveOnScroll: true,
            resizeWindow: true,
            close:'.closeBtn'
            
        },options);
       */
        var olay = $(options.olay);
        var modals = $(options.modals);
        var currentModal;
        var isopen=false;
       
        if (options.animationEffect==='fadein'){options.animationEffect = 'fadeIn';}
        if (options.animationEffect==='slidedown'){options.animationEffect = 'slideDown';}
        
        olay.css({opacity : 0});
                
        if(options.openOnLoad) {
            openModal();
        }else{
            olay.hide();
            modals.hide();
        }
        currentModal = $(modals);
        openModal();
        
        function openModal(){
           
            modals.hide();
            currentModal.css({
                top:$(window).height() /2 - currentModal.outerHeight() /2 + $(window).scrollTop(),
                left:$(window).width() /2 - currentModal.outerWidth() /2 + $(window).scrollLeft()
            });
                
            if(isopen===false){
                olay.css({opacity : options.opacity, backgroundColor: '#'+options.background});
                olay[options.animationEffect](options.animationSpeed);
                currentModal.delay(options.animationSpeed)[options.animationEffect](options.animationSpeed); 
                currentModal.show();
            }else{
            	
                currentModal.show();
            }
            
            isopen=true;
        }
        
        function moveModal(){
            modals
            .stop(true)
            .animate({
            top:$(window).height() /2 - modals.outerHeight() /2 + $(window).scrollTop(),
            left:$(window).width() /2 - modals.outerWidth() /2 + $(window).scrollLeft()
            },options.moveModalSpeed);
        }
        
        function closeModal(){
            $('.' + options.videoClass).attr('src',''); 
            isopen=false;
            modals.fadeOut(100, function(){
                if (options.animationEffect === 'slideDown') {
                    olay.slideUp();
                }else if (options.animationEffect === 'fadeIn') {
                    olay.fadeOut();
                }
            });
            return false;
        }
        
        if(options.docClose){
            olay.bind('click', closeModal);
        }
        
        $(options.close).bind('click', function(e){
        		closeModal();
        		$('.gettextarea').focus();
        	});
        
        $(options.close).bind('keydown', function(e){
                if(e.which === 13){
                    closeModal();
                    $('.gettextarea').focus();
                }
            });
        
        if (options.closeByEscape) {
            $(window).bind('keyup', function(e){
                if(e.which === 27){
                    closeModal();
                    $('.gettextarea').focus();
                }
            });
        }
        
        if (options.resizeWindow) {
            $(window).bind('resize', moveModal);
        }else{
            return false;
        }
        
        if (options.moveOnScroll) {
            $(window).bind('scroll', moveModal);
        }else{
            return false;
        }
    };
})(jQuery);
