import os
from flask import Flask, jsonify, make_response, request
import re
import datetime as dt
import requests
from bs4 import BeautifulSoup
 
app = Flask(__name__)
 
headers = {
    'User-Agent': os.environ['USER_AGENT'],
}

@app.route('/kabum')
def kabum_product():
    id = request.args.get('id')
    url = os.environ['KABUM_PRODUCT_URL'] + id
    page = requests.get(url, headers=headers)
    soup = BeautifulSoup(page.text, "html.parser")

    tagFinalPrice = soup.find(class_='finalPrice')    
    priceString = re.sub('[^\d,]', '', tagFinalPrice.string)
    priceString = priceString.replace(',', '.')

    tagName = soup.find(itemprop='name')    
    name = tagName.string

    now = dt.datetime.utcnow().isoformat()
    return {
        "price": priceString,
        "id": id,
        "name": name,
        "timestamp": now 
    }

if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)