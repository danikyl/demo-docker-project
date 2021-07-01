import requests
import json

data = []
url = 'http://localhost:8080/subscription/update'
with open('notificacoes.txt') as f:
    for line in f:
        if line != "\n":
            lineJson = json.loads(line.replace("\'", "\""))
            print(lineJson)
            response = requests.post(url, json=lineJson)

