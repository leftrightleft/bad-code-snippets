const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.send('<form method="GET" action="/setLanguage">' +
             '<input type="text" name="default" placeholder="Enter default language" />' +
             '<button type="submit">Set Language</button>' +
             '</form>');
});

app.get('/setLanguage', (req, res) => {
    const defaultLanguage = req.query.default;
    const responseHTML = setLanguageOptions(defaultLanguage);
    res.send(responseHTML);
});

function setLanguageOptions(defaultLanguage) {
    return `<OPTION value=1>${defaultLanguage}</OPTION>` +
           `<OPTION value=2>English</OPTION>`;
}

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`);
});