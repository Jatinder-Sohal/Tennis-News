import './App.css';
import {useState} from "react";

function App() {
    const [player, setPlayer] = useState('');
    const [result, setResult] = useState('');
    const playerChange = (e) => {
        setPlayer(e.target.value);
    };
    const handleSearch = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/search', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({player}),
            });
            setResult(await response.text())
        }catch (error) {
            console.error('Error fetching data:', error);
        }
    }
    return (
        <div className="App">
            <input
                type="text"
                value={player}
                onChange={playerChange}
                placeholder="Enter search query"
            />
            <button onClick={handleSearch}>Search</button>
            <h1>{result}</h1>
        </div>
    );
}

export default App;
