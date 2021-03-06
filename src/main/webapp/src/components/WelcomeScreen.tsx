import Typography from "@material-ui/core/Typography";
import {Button, Grid} from "@material-ui/core";
import {Link} from "react-router-dom";
import React from "react";
import ArrowForward from '@material-ui/icons/ArrowForward';
import logo from '../assets/logo.jpeg';
import Box from "@material-ui/core/Box";

const WelcomeScreen = () => {
  return (
    <div>
      <Grid container spacing={0}>
        <Grid item sm={3}>
          <img  src={logo} width={200} alt="Medical Reserve Logo" />
        </Grid>
        <Grid item sm={9}>
          <Typography variant="h2" component="h1" gutterBottom>
            Willkommen bei Medical Reserve
          </Typography>
          <Typography variant="h6" component="h2" paragraph={true} gutterBottom>
            Heute ist es wichtig zusammenzuhalten und gemeinsam die anstehenden Aufgaben zu bewältigen. <br/>  Jeder einzelne zählt und mit deiner Registrierung kannst du dabei helfen!
          </Typography>
          <Box>
            <Button component={Link} to="/signup" variant="contained" color="primary" size="large" endIcon={<ArrowForward/>}>Ich möchte helfen</Button>
          </Box>
          <Box mt={2}>
            <Button component={Link} to="/list" variant="outlined" color="primary" size="large" endIcon={<ArrowForward/>}>Zu den Freiwilligen</Button>
          </Box>
        </Grid>
      </Grid>
    </div>
  );
};

export default WelcomeScreen;
