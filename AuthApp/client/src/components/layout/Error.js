import React, { Component } from 'react';

class Error extends Component {
    render() {
        let errorMessage = "";

        try {
            errorMessage = this.props.location.state.errorMsg;
        } catch (err) {
            console.log(err);
        }

        return (
            <section className="form-background-error">
                <div className="container vertical-center">
                    <form>
                        <div className="container">
                            <center>
                                <h2>{errorMessage}</h2>
                            </center>
                        </div>
                    </form>
                </div>
            </section>
        )
    };
}

export default Error;
