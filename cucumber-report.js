const report = require('C://prueba');

report.generate({
    saveCollectedJSON: true,
    jsonDir: 'C://prueba',
    reportPath: 'C://prueba/',
    reportName: 'Pruebas',
    customMetadata: false,
    displayDuration: true,
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Prueba de Autoamtizacion'},
            {label: 'Release', value: 'REL'},
            {label: 'Execution Start Time', value: 'XYZ'},
            {label: 'Execution End Time', value: (new Date).toISOString().replace(/T/, ' ').replace(/\..+/, '')}
        ]
    }
});