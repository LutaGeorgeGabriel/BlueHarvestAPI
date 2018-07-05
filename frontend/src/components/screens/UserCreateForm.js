import React from 'react';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
import Service from '../service/Service'
import Face from 'material-ui/svg-icons/action/face';

const style = {
    floatingLabelColor: {
        color: "#000"
    }
};

const UserCreateForm = ({onNameChange, onSurnameChange, name, surname}) => {
    return (
        <div style={{backgroundColor: "green"}}>
            <div>
                USER
                <Face />
            </div>
            <TextField
                floatingLabelText="Name"
                underlineShow={false}
                value={name}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onNameChange(event, value)}/>
            <TextField
                floatingLabelText="Surname"
                underlineShow={false}
                value={surname}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onSurnameChange(event, value)}/>
            <FlatButton
                label="CREATE"
                secondary={true}
                onClick={() => Service.create({
                    name: name,
                    surname: surname
                })}/>
        </div>
    )
};

UserCreateForm.defaultProps = {
    name: "",
    surname: ""
};

export default UserCreateForm;