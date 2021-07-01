import requests
import json
import time

urlPost = 'http://localhost:8080/subscription/update'
urlGetSubscription = 'http://localhost:8080/subscription/all'
urlGetEventHistory = 'http://localhost:8080/eventHistory/all'

with open('notificacoes.txt') as f:
    for line in f:
        if line != "\n":
            lineJson = json.loads(line.replace("\'", "\""))
            print('Performing request: ',lineJson)
            response = requests.post(urlPost, json=lineJson)

time.sleep(2)
dataSubscription = requests.get(urlGetSubscription)
print('------------------SUBSCRIPTIONS STATUS------------------')
for item in dataSubscription.json():
    print(item)

dataEventHistory = requests.get(urlGetEventHistory)
print('------------------EVENT HISTORY------------------')
for item in dataEventHistory.json():
    print(item)
