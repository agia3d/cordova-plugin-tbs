var exec = require('cordova/exec');

module.exports = {
     getVersion: function(successFunction, failFunction) {
         exec(successFunction, failFunction, "X5Webview", "gv", []);
     }
};
