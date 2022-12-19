import React, { useState, useEffect, useCallback } from "react";
import "./EditContact.css";
import { Link, useParams, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.min.css";

function EditContact() {
  const params = useParams();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState(0);

  let navigate = useNavigate();

  const fetchContact = useCallback(() => {
    fetch(`http://localhost:4444/api/contacts/${params.id}`, {
      method: "GET",
    })
      .then((response) => response.json())
      .then((response) => {
        setName(response.name);
        setPhone(response.phone);
        setEmail(response.email);
      });
  }, [params.id]);

  useEffect(() => {
    fetchContact();
  }, [fetchContact]);

  const updateContact = (event) => {
    event.preventDefault();
    console.log(name);
    fetch(`http://localhost:4444/api/contacts/${params.id}`, {
      method: "PUT",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({ name, phone, email }),
    })
      .then(() => navigate("/"))
      .then(
        toast.success("You edited a contact!", {
          position: toast.POSITION.TOP_CENTER,
        })
      );
  };

  return (
    <div className="edit-contact">
      <h2 className="header">
        <div>
          <i className="bi bi-arrow-left"></i>
          <Link
            to="/"
            style={{
              cursor: "pointer",
              textDecoration: "none",
              color: "black",
            }}
          >
            Back to the homepage
          </Link>
        </div>
        <div>Edit a Contact</div>
      </h2>
      <form onSubmit={updateContact} className="html-form">
        <div className="label-input-container">
          <label className="label-container">Name:</label>
          <input
            className="input-container"
            type="text"
            name="name"
            required
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
        </div>
        <div className="label-input-container">
          <label className="label-container">Phone Number:</label>
          <input
            className="input-container"
            type="number"
            name="age"
            required
            value={phone}
            onChange={(event) => setPhone(event.target.value)}
          />
        </div>
        <div className="label-input-container">
          <label className="label-container">Email:</label>
          <input
            className="input-container"
            type="email"
            name="email"
            required
            value={email}
            onChange={(event) => setEmail(event.target.value)}
          />
        </div>
        <button className="submit-button" type="submit">
          Submit
        </button>
      </form>
    </div>
  );
}

export default EditContact;
