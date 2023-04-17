import json

from pprint import pprint

factors = [""]


class BDController:
    file_name = "./stat.json"
    def _start(self):
        self.file_name = "./stat.json"
        self.file = open(self.file_name, "r")

    def __init__(self):
        pass

    def getAll(self):
        with open(self.file_name, "r") as f:
            base = json.loads(f.read())

        return base

    def setData(self, data: dict):
        with open(self.file_name, "r") as f:
            base = json.loads(f.read())
        base.append(data)
        with open(self.file_name, "w") as f:
            f.write(json.dumps(base))
        return

    def _close(self):
        self.file.close()


bd = BDController()
bd.getAll()
