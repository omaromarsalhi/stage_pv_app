import React from "react";
import { PvTable } from "@/pages/dashboard/index.js";
import "../../../public/css/style.css";
import { RiDownloadCloud2Line } from "react-icons/ri";
import html2pdf from "html2pdf.js";

const Popup = ({ show, student,onClose }) => {

  const generatePDF = () => {
    const element = document.getElementById("pdf-content");
    const options = {
      margin: [0.5, 0.5, 0.5, 0.5],
      filename: student.name+".pdf",
      image: { type: "jpeg", quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { unit: "in", format: "letter", orientation: "portrait" },
    };

    html2pdf().from(element).set(options).save();
  };

  return (
    <div
      className={`fixed inset-0 flex items-center justify-center z-50 ${show ? "opacity-100 pointer-events-auto" : "opacity-0 pointer-events-none"} transition-opacity duration-300`}>
      <div className="fixed inset-0 bg-black bg-opacity-50 transition-opacity duration-300"></div>
      <div
        className={`bg-white rounded-lg p-8 z-10 transform ${show ? "scale-100" : "scale-95"} transition-transform duration-300`}>
        <div id="pdf-content">
          <h2 className="text-xl mb-4 font-bold text-center">Resultat Session Principale</h2>
          <h2 className="text-xl font-bold text-center">Name: <span className="text-red-700">{student.name}</span></h2>
          <h2 className="text-xl font-bold text-center">Identifiant: <span className="text-red-700">{student.identifier}</span>
          </h2>
          <h2 className="text-xl font-bold text-center">Class: <span className="text-red-700">{student.grade}</span></h2>
          <PvTable />
        </div>
        <div className="flex items-center justify-end gap-2">
          <button className="bg-green-700 text-white px-4 py-2 rounded" onClick={generatePDF}>
            <RiDownloadCloud2Line />
          </button>
          <button className="bg-red-700 text-white px-4 py-2 rounded" onClick={onClose}>Close</button>
        </div>
      </div>
    </div>
  );
};

export default Popup;


// import React from "react";
// import { PvTable } from "@/pages/dashboard/index.js";
// import '../../../public/css/style.css'
// import { RiDownloadCloud2Line } from "react-icons/ri";
// import html2pdf from 'html2pdf.js';
//
// const Popup = ({ show, onClose }) => {
//
//   const generatePDF = () => {
//     console.log("nnn");
//     const element = document.getElementById('pdf-content');
//     const options = {
//       margin: [0.5, 0.5, 0.5, 0.5],
//       filename: './popup.pdf',
//       image: { type: 'jpeg', quality: 0.98 },
//       html2canvas: { scale: 2 },
//       jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
//     };
//
//     html2pdf().from(element).set(options).save();
//   };
//
//   return (
//     <div
//       className={`fixed inset-0 flex items-center justify-center z-50 ${show ? "opacity-100 pointer-events-auto" : "opacity-0 pointer-events-none"} transition-opacity duration-300`}>
//       <div className="fixed inset-0 bg-black bg-opacity-50 transition-opacity duration-300"></div>
//       <div
//         className={`bg-white rounded-lg p-8 z-10 transform ${show ? "scale-100" : "scale-95"} transition-transform duration-300`}>
//         <h2 className="text-xl text-[20px] mb-4 font-bold text-center">Rsultat Session Principale</h2>
//         <h2 className="text-xl text-size font-bold text-center">Name : <span className="text-red-700">omar salhi</span>
//         </h2>
//         <h2 className="text-xl text-size font-bold text-center">Identifient : <span
//           className="text-red-700">211JMT9581</span></h2>
//         <h2 className="text-xl text-size font-bold text-center">Class : <span className="text-red-700">3A4</span></h2>
//
//         <PvTable />
//
//         <div className="flex items-end justify-end self-end gap-2 h-5">
//           <button className="bg-green-700 text-white px-4 py-2 rounded" onClick={generatePDF}>
//             <RiDownloadCloud2Line />
//           </button>
//           <button className="bg-red-700 text-white px-4 py-2 rounded" onClick={onClose}>Close</button>
//         </div>
//       </div>
//     </div>
//   );
// };
//
// export default Popup;
