//
//  MyController.swift
//  iosApp
//
//  Created by Leonid on 28.02.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import Foundation
import shared

class MyController: UIViewController {
    
    @IBOutlet weak var mButton: UIButton!
    @IBOutlet weak var mText: UILabel!
    
    private var simpleViewModel: SimpleViewModel = SimpleViewModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configView()
        initViewModel()
    }
    
    func configView() {
        self.mButton.addTarget(self, action: #selector(didButtonAddDataBaseClick), for: .touchUpInside)
        self.mText.text = "No data yet..."
    }
    
    func initViewModel() {
        simpleViewModel.messageLiveData.addObserver { (value) in
            self.mText.text = value?.text
        }
    }
    
    @objc func didButtonAddDataBaseClick(_ sender: UIButton) {
        simpleViewModel.next()
    }
    
}
