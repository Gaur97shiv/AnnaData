// src/components/FarmerContracts.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';

const FarmerContracts = () => {
    const [contracts,
        setContracts] = useState([]);
    const [loading,
        setLoading] = useState(true);
    const [error,
        setError] = useState(null);

    // Fetch data from Spring Boot API
    useEffect(() => {
        axios
            .get('http://localhost:8080/farmer-contracts/all')
            .then((response) => {
                setContracts(response.data); // Store the response data in state
                setLoading(false); // Set loading to false
            })
            .catch((err) => {
                setError(err.message); // Set error if any
                setLoading(false);
            });
    }, []); // Empty dependency array means this runs only once on component mount

    if (loading) {
        return <div> Loading...</div>
    }

    if (error) {
        return <div> Error: {error}</div>
    }

    return (
        <div>
            <h2> Farmer Contracts</h2>
            <ul>
                {contracts.map((contract) => (
                    <li key={contract.id}>
                        <p>
                            <strong>Farmer Name:</strong>
                            {contract.farmerName}</p>
                        <p>
                            <strong>Contract Details:</strong>
                            {contract.contractDetails}</p>
                        <p>
                            <strong>Start Date:</strong>
                            {contract.contractStartDate}</p>
                        <p>
                            <strong>End Date:</strong>
                            {contract.contractEndDate}</p>
                        <p>
                            <strong>Contract Amount:</strong>
                            {contract.contractAmount}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FarmerContracts;
