import React from 'react'
import { Dialog } from '../components/ui/dialog'
import { DialogContent, DialogTrigger } from '@radix-ui/react-dialog'
import { DialogHeader } from "../../components/ui/dialog"
const Navbar = () => {
  return (
    <div className='border-b py-4 px-5 flext items-center justify-between'>
        <div className='cursor-pointer '>
            <p>Project Management</p>
            <Dialog>
                <Dialog>
                    <DialogTrigger>
                        <Button variant="ghost" >New Project

                        </Button>
                    </DialogTrigger>
                    <DialogContent>
                        <DialogHeader>
                            Create New Project
                        </DialogHeader>
                    </DialogContent>
                </Dialog>
            </Dialog>
        </div>
    </div>
  )
}

export default Navbar