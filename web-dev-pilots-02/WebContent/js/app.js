require.config({

	baseUrl : 'js/lib',

	paths : {
		app : '../app',
		views : '../app/views',
		models : '../app/models',
		collections : '../app/collections',
		routers : '../app/routers',
		tpl : '../tpl',
		nls : '../nls',
		bootstrap : '../../bootstrap/js/bootstrap'
	},

	// Set the config for the i18n
	// locale : "en-us",

	map : {
		'*' : {
			'models/employee' : 'models/memory/employee'
		}
	},

	shim : {
		'backbone' : {
			deps : [ 'underscore', 'jquery' ],
			exports : 'Backbone'
		},
		'underscore' : {
			exports : '_'
		},
		'bootstrap' : {
			deps : [ 'jquery' ],
			exports : 'bootstrap'
		}
	}
});

require([ 'jquery', 'underscore', 'backbone', 'views/common/commonView', 'routers/router' ],
function(CommonView, Router) {
	var _sync = Backbone.sync;
	Backbone.sync = function(method, model, options) {
		options.error = function(model, response, options) {
			console.log('fetch error');
			console.log(model);
			console.log(response);
			console.log(options);
			if (options === 'Unauthorized') {
				eval(model.responseText);
			}
		};
		
		_sync(method, model, options);
	};
	console.log('start app');

	Backbone.history.start();
});
