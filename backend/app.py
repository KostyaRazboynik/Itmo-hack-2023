from flask import Flask, request
import bdRequests as bd

app = Flask(__name__)

base = bd.BDController()

facts = ["start_time", "data_size", "data_per_time", "duration"]


@app.route('/start_time', methods=["GET"])
def get_data1():
    return base.getAll()["start_time"]


@app.route('/data_size', methods=["GET"])
def get_data2():
    return base.getAll()["data_size"]


@app.route('/data_per_time', methods=["GET"])
def get_data3():
    return base.getAll()["data_per_time"]


@app.route('/duration', methods=["GET"])
def get_data4():
    return base.getAll()


# todo
@app.route('/addData', methods=['POST'])
def post_data():
    print("here")
    print(request.form.to_dict())
    base.setData(request.form.to_dict())

    return "123"


if __name__ == '__main__':
    # app.run()
    app.run(host="164.92.210.100")
# print(parseData([{"id": "3642626793764804437", "start_time": "1681634569956", "duration": "637", "name": "Test",
#                   "library": "OkHttp3", "type": "Get", "url": "https://cat-fact.herokuapp.com/facts",
#                   "data_size": "null", "exception": "null", "stack_trace": ""}]))
