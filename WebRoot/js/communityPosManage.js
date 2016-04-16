(function () {
	$(".communityPosManageAdd").click(function() {
		$("#pageInfo").find("#communityPosManage").append($(".communityPosManageDiv:first-child").clone());
	});


})();