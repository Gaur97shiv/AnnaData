import React, { useEffect, useState } from 'react';

const Contracts = () => {
    const [contracts, setContracts] = useState([]);

    useEffect(() => {
        fetch('/api/contracts') 
            .then((response) => response.json())
            .then((data) => setContracts(data))
            .catch((error) => console.error('Error fetching contracts:', error));
    }, []);

    return (
        <div>
            <h1>Farmer Contracts</h1>
            <ul>
                {contracts.map((contract) => (
                    <li key={contract.id}>
                        {contract.farmer_name} - {contract.contract_details} (${contract.contract_amount})
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Contracts;
