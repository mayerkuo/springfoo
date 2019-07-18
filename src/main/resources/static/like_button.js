'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
  constructor(props) {
    super(props);
    this.state = { liked: false };
  }

  render() {
    if (this.state.liked) {
      return 'You liked this.';
    }

    return e(
      'button',
      { onClick: () => this.setState({ liked: true }) },
      'Like'
    );
  }
}

class GenList extends React.Component {
   render() {
       return e('ul', null, [
        e('li', {key: 1}, 'item1'),
        e('li', {key: 2}, 'item2'),
        e('li', {key: 3}, 'item3'),
       ]);
     }
}


const domContainer = document.querySelector('#like_button_container');
ReactDOM.render(e(LikeButton), domContainer);

const domContainer2 = document.querySelector('#ul_container');
ReactDOM.render(e(GenList), domContainer2);