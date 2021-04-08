const express = require('express');
const router = express.Router();
const auth = require('../../middleware/auth');
const Profile = require('../../models/User');

//@route GET api/profile
router.get('/', auth, async (req, res) => {
    try {
        const profile = await Profile.findById(req.user.id).select('-password -id');

        if(!profile){
            return res.status(400).json({msg:"No profile found"});
        }
        res.josn(profile);
    } catch (err) {
        console.log(err.message);
        res.status(500).send('server error');
    }
});

module.exports = router;