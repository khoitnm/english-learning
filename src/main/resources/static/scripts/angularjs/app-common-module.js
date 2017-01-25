var AppCommon = (function (module) {
	module.generatePassword = function () {
		var passwordLength = Math.floor(Math.random() * 10);
		var charset = "abcdefghijklnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_=+()`~!@$%^&*",
	        result = "123-aB";
	    for (var i = 0, n = charset.length; i < passwordLength; ++i) {
	    	result += charset.charAt(Math.floor(Math.random() * n));
	    }
	    return result;
	};
	
	module.hasValue = function (value) {
		return (value !== undefined && value != null);
	};
	
	module.initCheckBoxTable = function(classMaster, classMember, isFromMaster) {
		if (isFromMaster) {
			if ($("." + classMaster).is(':checked')) {
				$("." + classMember).prop('checked', true);
			} else {
				$("." + classMember).prop('checked', false);
			}
			
			return;
		}
		
		var checkedAll = true;
		var cnt = $("." + classMember).length;

		for (var i = 0; i < cnt; i++) {
		  var node = $("." + classMember)[i];
		  if (!$(node).is(':checked')) {
		    checkedAll = false;
		    break;
		  }
		}
		
		if (checkedAll) {
			$("." + classMaster).prop('checked', true);
		} else {
			$("." + classMaster).prop('checked', false);
		}
	};

	return module;
}(AppCommon || {}));