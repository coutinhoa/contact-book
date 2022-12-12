import "./ContactBook.css";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function App() {
  const [contacts, setContacts] = useState([]);
  const [isAdding, setIsAdding] = useState(false);
  const [name, setName] = useState("");
  const [phone, setPhone] = useState(0);
  const [email, setEmail] = useState("");

  //useParams is no bueno cauyse we use useParams when we want something like this: localhost:3000/1
  //in this example useParams is useful when we want the page of a single user

  const fetchContacts = () => {
    fetch("http://localhost:4444/api/contacts")
      .then((response) => response.json())
      .then((response) => {
        setContacts(response);
      });
  };

  useEffect(() => {
    fetchContacts();
  }, []);

  const deleteContact = (id) => {
    console.log(id);
    if (id) {
      fetch(`http://localhost:4444/api/contacts/${id}`, {
        method: "DELETE",
      }).then(fetchContacts);
    }
  };

  //when we use a form we should use an event
  //if we don't use a form it is a value

  const addContact = () => {
    fetch("http://localhost:4444/api/contacts", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({
        //name(this is the backend key this.name): name (this is the variable setName)
        name: name,
        phone: phone,
        email: email,
      }),
    })
      .then(() => fetchContacts())
      .then(setIsAdding(false));
  };

  return (
    <div className="App">
      <h2>Contact Book</h2>
      <table className="contacts">
        <thead>
          <tr>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Delete Contact</th>
            <th>Edit Contact</th>
          </tr>
        </thead>
        <tbody>
          {contacts.map((person) => (
            <tr key={person.id}>
              <td>{person.name}</td>
              <td>{person.phone}</td>
              <td>{person.email}</td>
              <td>
                <span
                  className="remove-cursor"
                  onClick={() => deleteContact(person.id)}
                >
                  delete
                </span>
              </td>
              <td>
                <Link
                  to={`/edit-contact/${person.id}`}
                  style={{
                    cursor: "pointer",
                    textDecoration: "none",
                    color: "orange",
                    display: "flex",
                    justifyContent: "center",
                  }}
                >
                  edit
                  <i className="bi bi-pencil"></i>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
        {/*{isAdding === true ? (
          <tfoot>
            <td>Add name</td>
            <td>Add phone number</td>
            <td>Add Email</td>
            <td>Delete</td>
            <td>Edit</td>
          </tfoot>
        ) : null}*/}
        {isAdding && (
          <tfoot>
            <tr>
              <td>
                <input
                  className="input"
                  type="text"
                  placeholder="Add name"
                  onChange={(event) => setName(event.target.value)}
                />
              </td>
              <td>
                <input
                  className="input"
                  type="text"
                  placeholder="Add phone number"
                  onChange={(event) => setPhone(event.target.value)}
                  value={phone}
                />
              </td>
              <td>
                <input
                  className="input"
                  type="text"
                  placeholder="Add Email"
                  onChange={(event) => setEmail(event.target.value)}
                />
              </td>
              <td>Delete</td>
              <td>Edit</td>
            </tr>
          </tfoot>
        )}
      </table>
      {!isAdding && (
        <button className="button" onClick={() => setIsAdding(true)}>
          Add new Contact
        </button>
      )}
      {isAdding && (
        <div>
          <button className="button" onClick={addContact}>
            Submit
          </button>
          <button className="button" onClick={() => setIsAdding(false)}>
            Cancel
          </button>
        </div>
      )}
    </div>
  );
}

export default App;
