const fs = require('fs');
const { JSDOM } = require('jsdom');

const html = fs.readFileSync('../client/index.html', 'utf-8');

const dom = new JSDOM(html);

console.log(dom.window.document.querySelector("p").textContent);

dom.window.document.getElementById('button').addEventListener('click', () => {
    var numbers = dom.window.document.getElementById('numbers').value.split(',').map(Number);
    displayResult(numbers);
});

function displayResults(results) {
    var resultDiv = dom.window.document.getElementById('result');
    resultDiv.innerHTML = '';
    var ul = dom.window.document.createElement('ul');
    results.forEach(function(result) {
        var li = dom.window.document.createElement('li');
        li.textContent = result;
        ul.appendChild(li);
    });
    resultDiv.appendChild(ul);
}