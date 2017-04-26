import requests

url = 'http://localhost:8090/post_person'
headers = {'Content-Type': 'application/json'}
data = '{"firstName":"Kimi","lastName":"Raikkonen","age":37}'

r = requests.post(url, data, headers=headers)
r.status_code
