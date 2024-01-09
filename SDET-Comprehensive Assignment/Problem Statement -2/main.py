import csv

class ReadAndWriteData:
    def __init__(self, csv_file):
        self.csv_file = csv_file
        self.data = []

    def read_data_from_csv(self):
        with open(self.csv_file, 'r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                self.data.append(row)

    def display_data(self):
        for record in self.data:
            print(f"Name: {record['Name']}, SkillSet: {record['SkillSet']}, Experience: {record['Experience']}")

# Example Usage
csv_file_path = r'C:/Users/Srivani/Downloads/PythonData.csv'
data_handler = ReadAndWriteData(csv_file_path)
data_handler.read_data_from_csv()
data_handler.display_data()