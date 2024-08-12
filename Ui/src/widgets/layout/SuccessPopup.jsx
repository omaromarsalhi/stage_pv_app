import React, { useEffect } from "react";

function SuccessPopup({ message, onClose }) {
  useEffect(() => {
    const timer = setTimeout(onClose, 3000); // Close after 3 seconds
    return () => clearTimeout(timer);
  }, [onClose]);

  return (
    <div className="fixed inset-0 flex items-center justify-center z-50 min-h-400 min-w-500">
      <div className="bg-green-500 text-green-700 p-4 rounded-lg shadow-lg transform transition-transform duration-300 ease-in-out scale-100">
        <div className="flex items-center">
          <div className="w-10 h-10 bg-green-500 rounded-full flex items-center justify-center">
            <svg
              className="w-6 h-6 text-white"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M5 13l4 4L19 7"
              ></path>
            </svg>
          </div>
          <span className="ml-3 text-lg font-semibold text-cyan-50">{message}</span>
        </div>
      </div>
    </div>
  );
}

export default SuccessPopup;
