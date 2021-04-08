import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { createBrowserHistory } from 'history';

let history = createBrowserHistory();

function Login() {
    const [formData, setFormData] = useState({
        email: '',
        password: ''
    });

    const { email, password } = formData;
    const onChange = e =>
        setFormData({ ...formData, [e.target.name]: e.target.value });

    const onSubmit = async e => {
        e.preventDefault();

        const User = { email, password };

        try {
            const config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            const body = JSON.stringify(User);
            const res = await axios.post('/api/login', body, config);
            //history.push('/profile');

            history.push({
                pathname: '/profile',
                state: { userName: res.data.userName }
            });
            history.go('/profile');
            console.log(res.data.userName);
        } catch (err) {
            history.push({
                pathname: '/error',
                state: { errorMsg: "No user exists!!" }
            });
            history.go('/error');
            //alert(err.response.data);
        }

    }

    return (
        <section className="form-background">
            <div className="container vertical-center">
                <form onSubmit={e => onSubmit(e)}>
                    <div className="container">
                        <center>
                            <h2>DSI Web Application</h2> <br /><br /> <br />
                        </center>
                        <input className="line" type="text" placeholder="Enter Email" name="email" value={email}
                            onChange={e => onChange(e)} required /> <br />
                        <input className="line" type="password" placeholder="Enter Password" name="password" value={password}
                            onChange={e => onChange(e)} required /> <br />
                        <input className="btn-success btn-custom" type="submit" value="Login" />
                        <Link to="/">
                            <button type="button" className="btn-danger btn-custom">
                                Cancel
                            </button>
                        </Link>
                        <br /> <br />
                        <Link to="/register" className="link-reg">Create account?</Link>
                    </div>
                </form>
            </div>
        </section>
    );
}

export default Login;
