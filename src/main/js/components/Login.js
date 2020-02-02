import React from 'react';
import {DivMainContent} from '../styles';

const Login = () => (
    <DivMainContent>
        <h1 style={{marginRight: "50%"}}>Login page</h1>
        <div id="login">
            <h1>Welcome Back!</h1>

            <form action="#" method="post">

                <div>
                    <label>Account   <span class="req"></span></label>
                    <input style={{marginLeft: '0.8%'}} type="email" required
                           autocomplete="off"/>
                </div>
                <div>
                    <label>Password </label>
                    <input type="password" required
                           autocomplete="off"/>
                </div>

                <p>
                    <a href="#">Forgot Password?</a>
                </p>

                <button>Log In</button>
            </form>

        </div>
    </DivMainContent>
);
export default Login;
