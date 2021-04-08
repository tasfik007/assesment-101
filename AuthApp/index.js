const express = require('express');
const connectDB = require('./config/db');
const app = express();

connectDB();

app.get('/', (req, res) => {
    res.send('API is working..');
});

app.use(express.json({ extended: false }));
// Geting routes
app.use('/api/regester', require('./routes/api/regester'));
app.use('/api/login', require('./routes/api/login'));
app.use('/api/profile', require('./routes/api/profile'));

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log("Server started on port: ", PORT);
});