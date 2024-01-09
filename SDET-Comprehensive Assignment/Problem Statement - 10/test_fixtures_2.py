import unittest

def home_page_data():
    return{

        "title" : "Automation Anywhere",
        "description" : "Automation Anywhere Platform, delivers secure enterprise automation alongside process intelligence to improve operational efficiency, accelerate business process and increase cost savings."

    }

class TestHomePage(unittest.TestCase):

    def setUp(self):
        pass
    def tearDown(self):
        pass
    
    def test_home_page_title(self):
        data = home_page_data()
        self.assertIn("title", data)
        self.assertEqual(data["title"], "Automation Anywhere")

    def test_home_page_description(self):
        data = home_page_data()
        self.assertIn("description", data)
        self.assertIn("Automation Anywhere Platform", data["description"])