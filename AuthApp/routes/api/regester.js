const express = require('express');
const router = express.Router();
const { check, validationResult } = require('express-validator');

const bcrypt = require('bcryptjs');
const config = require('config');
const jwt = require('jsonwebtoken');
const User = require('../../models/User');

//@route GET api/regester
router.post('/', [
    check('name', 'Name is required').not().isEmpty(),
    check('email', "Please include a valid email").isEmail(),
    check('password', "Please enter a password with 8 or more characters").isLength({ min: 8 })
], async (req, res) => {
    const error = validationResult(req);
    if (!error.isEmpty()) {
        return res.status(400).json({ errors: error.array() });
    }

    const { name, email, password } = req.body;

    try {
        //see if user exists
        let user = await User.findOne({ email });
        if (user) {
            return res.status(400).json({ errors: [{ msg: 'User already exists' }] });
        }

        user = new User({
            name,
            email,
            password
        });
        //encrypt password
        const salt = await bcrypt.genSalt(10);
        user.password = await bcrypt.hash(password, salt);
        //send to database
        await user.save();
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
                res.json({ token });
            }
        );
    } catch (err) {
        console.log(err.message);
        res.status(500).send('Server error');
    }

});

module.exports = router;