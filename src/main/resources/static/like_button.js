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
        e('li', {key: 1}, [
                'item1',
                e('button', {key: 1-1}, 'btn1')
            ]),
        e('li', {key: 2}, 'item2'),
        e('li', {key: 3}, 'item3'),
       ]);
     }
}

class ClickAndRender extends React.Component {
    render() {
        return e(
        'button',
        {
            onClick: () => {
                console.log('on btn click');
                const domContainer2 = document.querySelector('#ul_container');
                ReactDOM.render(e(GenList), domContainer2);
            }
        },
        'render it')
    }
}

const domContainer = document.querySelector('#like_button_container');
ReactDOM.render(e(LikeButton), domContainer);

const domContainer_render_test = document.querySelector('#render_test');
ReactDOM.render(e(ClickAndRender), domContainer_render_test);

//const domContainer2 = document.querySelector('#ul_container');
//ReactDOM.render(e(GenList), domContainer2);