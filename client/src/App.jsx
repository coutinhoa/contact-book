import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import ContactBook from "./ContactBook";
import EditContact from "./EditContact";

export default function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ContactBook />} />
          <Route path="/edit-contact/:id" element={<EditContact />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}
