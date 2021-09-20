var fs = require('fs');
var obj = JSON.parse(fs.readFileSync('FILENAME.json', 'utf8'));

const metadata = {
	"browser": {
		"name": "BROWSER",
		"version": "BVERSION"
	},
	"device": "DEVICE",
	"platform": {
		"name": "PLNAME",
		"version": "PLVERSION"
	}
}

obj[0].metadata = metadata
console.log(obj[0])
fs.writeFileSync('FILENAME.json', JSON.stringify(obj))