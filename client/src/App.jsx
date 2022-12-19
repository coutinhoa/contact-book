import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import ContactBook from "./ContactBook";
import EditContact from "./EditContact";
import { ToastContainer } from "react-toastify";

export default function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ContactBook />} />
          <Route path="/edit-contact/:id" element={<EditContact />} />
        </Routes>
      </BrowserRouter>
      <ToastContainer />
    </div>
  );
}
