import React from 'react';

const ModuleSelector = ({ modules = [], onChange }) => {
    return (
        <div>
            <label htmlFor="module">Select Module:</label>
            <select id="module" onChange={(e) => onChange(e.target.value)}>
                <option value="">Select...</option>
                {modules.map((module) => (
                    <option key={module.id} value={module.id}>
                        {module.name}
                    </option>
                ))}
            </select>
        </div>
    );
};

export default ModuleSelector;
