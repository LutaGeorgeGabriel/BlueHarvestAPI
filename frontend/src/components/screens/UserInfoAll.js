import React from 'react';
import axios from 'axios';
import User from "../User";

// created UserInfoAll as a class in order to use the componentDidMount lifecycle method
class UserInfoAll extends React.Component {
    constructor(props) {
        super(props);
    };

    componentDidMount() {
        axios.get('http://localhost:8080/fetch')
            .then((response) => {
                console.log(response.data);
                this.props.onUsersChange(response.data);
            })
            .catch((error) => {
                console.log("Error occurred when fetching the data ...", error);
            })
    }


    render() {
        console.log(this.props.users);
        return (
            <div>
                {
                    this.props.users.map((user, index) => {
                        return <User {...user} key={index}/>
                    })
                }
            </div>
        )
    }
};

export default UserInfoAll;