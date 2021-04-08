const express = require('express');
const router = express.Router();
const auth = require('../../middleware/auth');
const User = require('../../models/User');

const bcrypt = require('bcryptjs');
const { check, validationResult } = require('express-validator');
const config = require('config');
const jwt = require('jsonwebtoken');
//@route GET api/login
router.get('/', auth, async (req, res) => {
    try {
        const user = await User.findById(req.user.id).select('-password');
        res.json(user);
    } catch (err) {
        console.log(err.message);
        res.status(500).send('Server error');
    }
});

//@route GET api/login
router.post('/', [
    check('email', "Please include a valid email").isEmail(),
    check('password', "Password is required").exists()
], async (req, res) => {
    const error = validationResult(req);
    if (!error.isEmpty()) {
        return res.status(400).json({ errors: error.array() });
    }

    const { email, password } = req.body;

    try {
        //see if user exists
        let user = await User.findOne({ email });
        let userName = user.name;
        if (!user) {
            return res.status(400).json({ errors: [{ msg: 'Invalid credentials' }] });
        }
        const isMatch = await bcrypt.compare(password, user.password);

        if (!isMatch) {
            return res.status(400).json({ errors: [{ msg: 'Invalid credentials' }] });
        }

        //return jwt
        const payload = {
            user: {
                id: user.id
            }
        }

        jwt.sign(payload,
            config.get('jwtToken'),
            { expiresIn: 360000 },
            (err, token) => {
                if (err) throw err;
                res.json({ userName });
            }
        );
    } catch (err) {
        console.log(err.message);
        res.status(500).send('Server error');
    }

});

module.exports = router;

module.exports = router;