import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    
    var body: some View {
        VStack {
            Text(greet)
            Text(greet)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}