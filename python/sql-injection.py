import psycopg2
from flask import Flask, request, render_template
from server.models import Book

# Initialize Flask app
flaskapp = Flask(__name__)

# Database connection parameters
conn_params = {
    'dbname': 'your_dbname',
    'user': 'your_username',
    'password': 'your_password',
    'host': 'localhost'
}

# Establish a database connection
conn = psycopg2.connect(**conn_params)
cursor = conn.cursor()

@flaskapp.route('/')
def index():
    name = request.args.get('name')
    author = request.args.get('author')
    read = bool(request.args.get('read'))

    if name:
        cursor.execute(
            "SELECT * FROM books WHERE name LIKE '%" + name + "%'"
        )
        books = [Book(*row) for row in cursor]

    elif author:
        cursor.execute(
            "SELECT * FROM books WHERE author LIKE '%" + author + "%'"
        )
        books = [Book(*row) for row in cursor]

    else:
        cursor.execute("SELECT name, author, read FROM books")
        books = [Book(*row) for row in cursor]

    return render_template('books.html', books=books)


if __name__ == '__main__':
    flaskapp.run(debug=True)
