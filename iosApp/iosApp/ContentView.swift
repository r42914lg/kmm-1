import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private var state: ObservableHomeState
    private var simpleViewModel: SimpleViewModel = SimpleViewModel()
    
    init() {
        state = (simpleViewModel.messageLiveData.value?.wrapAsObservable())!
        // Я НЕ ЗНАЮ КАК ПОДИСАТЬСЯ НА ЛАЙВДАТУ В аЙоС - FUCK!!! ((((
        //simpleViewModel.messageLiveData.addObserver { (value) in }
    }
    
	var body: some View {
        Text(state.value.text)
        
        Button {
            simpleViewModel.next()
        } label: {
            Text("next")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}

class ObservableHomeState : ObservableObject {
    @Published var value: HomeState
    
    init(value: HomeState) {
        self.value = value
    }
}

extension HomeState {
    func wrapAsObservable() -> ObservableHomeState {
        return ObservableHomeState(value: self)
    }
}
