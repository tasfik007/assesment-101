import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { createBrowserHistory } from 'history';
let history = createBrowserHistory();

function Register() {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        password: '',
        password2: ''
    });

    const { name, email, password, password2 } = formData;
    const onChange = e =>
        setFormData({ ...formData, [e.target.name]: e.target.value });

    const onSubmit = async e => {
        e.preventDefault();
        if (password !== password2) {
            alert("Passwords do not match");
        }
        else {
            const newUser = { name, email, password };

            try {
                const config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }

                const body = JSON.stringify(newUser);
                const res = await axios.post('/api/regester', body, config);
                history.push('/');
                history.go('/');
                console.log(res.data);
            } catch (err) {
                history.push({
                    pathname: '/error',
                    state: { errorMsg: "Regestration failed!!" }
                });
                history.go('/error');
                //console.log(err.response.data.errors[0].msg);
            }
        }
    }


    return (
        <section className="form-background">
            <div className="container vertical-center">
                <form onSubmit={e => onSubmit(e)}>
                    <div className="container">
                        <center>
                            <h2>DSI Web Application</h2> <br />
                        </center>
                        <input className="line" type="text" placeholder="Enter Your Name" name="name" value={name}
                            onChange={e => onChange(e)}
                            required /> <br />
                        <input className="line" type="email" placeholder="Enter Email" name="email" value={email}
                            onChange={e => onChange(e)} required /> <br />
                        <input className="line" type="password" placeholder="Enter Password" name="password" minlength="8" value={password}
                            onChange={e => onChange(e)} required /> <br />
                        <input className="line" type="password" placeholder="Enter Password Again" name="password2" value={password2}
                            onChange={e => onChange(e)} required /> <br />
                        <input className="btn-success btn-custom" type="submit" value="Register" />
                        <Link to="/">
                            <button type="button" className="btn-danger btn-custom">
                                Cancel
                            </button>
                        </Link>
                    </div>
                </form>
            </div>
        </section>
    );
}

export default Register;
