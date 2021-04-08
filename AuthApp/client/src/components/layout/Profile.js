import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { createBrowserHistory } from 'history';
let history = createBrowserHistory();
class Profile extends Component {
    render() {
        let userName = "";

        try {
            userName = this.props.location.state.userName;
        } catch (err) {
            history.push('/');
            history.go('/');
            //alert("You are not authorized to enter!!");
        }


        return (
            <section className="form-background">
                <div className="container vertical-center">
                    <form>
                        <div className="container">
                            <center>
                                <h2>Hello {userName}!!</h2>
                                <h2>Welcome to your profile.</h2> <br />
                            </center>
                            <Link to="/">
                                <center>
                                    <i class="logout-icon fas fa-sign-out-alt fa-3x"></i>
                                </center>
                                {/*<button type="button" className="btn-danger btn-custom">
                                    LogOut
        </button>*/}
                            </Link>

                        </div>
                    </form>
                </div>
            </section>
        )
    };
}

export default Profile;
